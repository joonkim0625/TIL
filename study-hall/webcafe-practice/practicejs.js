var item = $('.menu-item');
var subItem = $('.sub-menu a');
var tab = $('.tab');


item.attr('tabindex', '0');
subItem.attr('class', 'fas fa-angle-left');
tab.attr('tabindex', '0');

// .on  

item.on('mouseover focusin', function(){
  item.removeClass('menu-act');
  $(this).addClass('menu-act');
});

subItem.hover(function(){
  $(this).toggleClass('fa-angle-right');
});


tab.on('click focusin', function(){
  $(this).parent().siblings().removeClass();
  $(this).parent().addClass('tab-act');
});