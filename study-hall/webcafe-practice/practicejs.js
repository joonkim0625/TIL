var item = $('.menu-item');
var subItem = $('.sub-menu a');

item.attr('tabindex', 0);
subItem.attr('class', 'fas fa-angle-left');

// .on  

item.on('mouseover focusin', function(){
  item.removeClass('menu-act');
  $(this).addClass('menu-act');
});

subItem.hover(function(){
  $(this).toggleClass('fa-angle-right');
});