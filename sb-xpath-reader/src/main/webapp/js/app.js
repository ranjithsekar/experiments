$.fn.fullSelector = function () {
    var path = this.parents().addBack();
    var quickCss = path.get().map(function (item) {
        var self = $(item),
            id = item.id ? '#' + item.id : '',
            clss = item.classList.length ? item.classList.toString().split(' ').map(function (c) {
                return '.' + c;
            }).join('') : '',
            name = item.nodeName.toLowerCase(),
            index = self.siblings(name).length ? ':child(' + (self.index() + 1) + ')' : '';
        
        if (name === 'html' || name === 'body') {
            return name;
        }
        return name + index + id + clss;
        
    }).join('/');
    return quickCss;
};

$(document).on('click','*', function() {
	// alert($(this).fullSelector());
    $('#xpathvalue').text( $(this).fullSelector() );
    return false;
});

var $iframe = $('myframe');
$iframe.load(function(){       
    var $iframeBody = $iframe.contents().find('body'); 

    alert($iframeBody.height()); 

    /*** 
    IE6 does not like it when you try an insert an element 
    that is not made in the target context. 
    Make sure we create the element with the context of 
    the iframe's document. 
    ***/ 
    var $newDiv = $('<div/>', $iframeBody.get(0).ownerDocument); 
    $newDiv.css('height', 2000); 

    $iframeBody.empty().append($newDiv); 

    alert($iframeBody.height()); 
  }); 