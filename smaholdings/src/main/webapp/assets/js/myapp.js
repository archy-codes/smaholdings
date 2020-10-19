$(function(){
	switch(menu){
	case'about us':
		$('#about').addClass('active');
		break;
	case'services':
		$('#services').addClass('active');
		break;
	case'projects':
		$('#projects').addClass('active');
		break;
	case'our blog':
		$('#blog').addClass('active');
		break;
	case'contact us':
		$('#contact').addClass('active');
		break;
		default:
			$('#home').addClass('active');
			break;
	}
});