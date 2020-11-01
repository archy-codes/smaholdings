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
		$('#a_'+menu).addClass('active');
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
	
	
	var $table = $('#projectListTable');
	
	if($table.length){
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUr = window.contextRoot + '/json/data/all/projects';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/projects';
		}
		
		$table.dataTable({
			lengthMenu: [[3,5,10,-1],['3 Projects','5 Projects','10 Projects','All']],
			pageLength: 5,
			ajax:{
				url: jsonUrl,
				dataSrc:''	
			},
			columns:[
				
				{
					data: 'code',
					mRender: function(data,type,row){
						
						return '<img id="dataTableImages" src="'+window.contextRoot+'/resources/images/'+data+'.jpg"/>';
					}
				},
				{
					data: 'projectName'
				},
				{
					data: 'client'
				},
				{
					data: 'description'
				},
				{
					data: 'value'
					
				},
				{
					data: 'contactDetails'
				},
				{
					data: 'status'
				},
				{
					data: 'id',
					mRender: function(data,type,row){
						var str = '';
						str += '<a href="'+window.contextRoot+ '/show/'+data+'/project"><i class="fas fa-eye text-center" style="width:30px; height:30px;"></i></a>';
						return str;
					}
				},
			]
		});
	}
	
	//dismissing the alert after 5 seconds
	var $alert = ('.alert');
	if($alert.length){
		setTimeOut(function(){
			$alert.fadeOut('slow');
		},5000)
	}
	
});