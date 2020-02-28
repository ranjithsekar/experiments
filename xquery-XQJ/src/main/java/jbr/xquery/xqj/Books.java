package jbr.xquery.xqj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQSequence;
import javax.xml.xquery.XQStaticContext;

import oracle.xml.xquery.OXQConnection;
import oracle.xml.xquery.OXQDataSource;
import oracle.xml.xquery.OXQEntity;
import oracle.xml.xquery.OXQEntityKind;
import oracle.xml.xquery.OXQEntityLocator;
import oracle.xml.xquery.OXQEntityResolver;
import oracle.xml.xquery.OXQEntityResolverRequestOptions;
import oracle.xml.xquery.OXQView;

public class Books {
  private static class MyEntityResolver extends OXQEntityResolver {
    @Override
    public OXQEntity resolveEntity(OXQEntityKind kind, OXQEntityLocator locator,
        OXQEntityResolverRequestOptions options) throws IOException {
      if (kind == OXQEntityKind.DOCUMENT) {
        URI systemId = locator.getSystemIdAsURI();
        if ("file".equals(systemId.getScheme())) {
          File file = new File(systemId);
          FileInputStream input = new FileInputStream(file);
          OXQEntity result = new OXQEntity(input);
          result.enlistCloseable(input);
          return result;
        }
      }
      return null;
    }
  }

  public static void main(String[] args) throws XQException, IOException {
    OXQDataSource ds = new OXQDataSource();
    XQConnection con = ds.getConnection();

    // OXQView is used to access Oracle extensions on XQJ objects.
    OXQConnection ocon = OXQView.getConnection(con);
    ocon.setEntityResolver(new MyEntityResolver());

    File query = new File("example1.xqy");

    // Relative URIs are resolved against the base URI before invoking the
    // entity resolver.
    // The relative URI 'books.xml' used in the query will be resolved
    // against this URI.
    XQStaticContext ctx = con.getStaticContext();
    ctx.setBaseURI(query.toURI().toString());

    FileInputStream queryInput = new FileInputStream(query);
    XQPreparedExpression expr = con.prepareExpression(queryInput, ctx);
    queryInput.close();
    XQSequence result = expr.executeQuery();
    System.out.println(result.getSequenceAsString(null));

    result.close();
    expr.close();
    con.close();
  }
}
