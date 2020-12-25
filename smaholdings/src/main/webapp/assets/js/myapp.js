$(function(){
	
	
	
	
	
	
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {			
			xhr.setRequestHeader(header,token);			
		});				
	}
	
	
	
	
	//navigation menu
	switch(menu){
	case'about us':
		$('#about').addClass('activemenu');
		break;
	case'services':
		$('#services').addClass('activemenu');
		break;
	case'projects':
		$('#projects').addClass('activemenu');
		break;
	case'gallery':
		$('#gallery').addClass('activemenu');
		break;
	case'all blogs':
		$('#blog').addClass('activemenu');
		break;
	case'contact us':
		$('#contact').addClass('activemenu');
		break;
	case'manage projects':
		$('manageProjects').addClass('activemenu');
		default:
			$('#home').addClass('activemenu');
			break;
	}
	
	
	
	//this is the blog section
	var $table = $('#myblog');
	
	if($table.length){
		
		var jsonUrl = '';
		
		if(window.blogCategoryId == ''){
			jsonUrl = window.contextRoot+'/json/data/latest/blogs';
		}else{
			jsonUrl = window.contextRoot+'/json/data/blogcategory/'+window.blogCategoryId+'/blogs';
		}
		
		$table.DataTable({
			lengthMenu:[[3,6,-1],['3 blogs','6 blogs','All']],
			pageLength: 3,
			ajax:{
				url: jsonUrl,
				dataSrc:''
			},
			columns:[
				{
					data: 'code',
					bSortable: false,
					mRender: function(data,type,row){
						
						return '<img id="dataTableImagesBlog" src="'+window.contextRoot+'/resources/images/'+data+'.jpg" >';
					
				}
				
				},
				
				{
					data: 'name'
				},
				{
					data: 'description'
				},
				{
				   data: 'blogdate'	
				},
				{
				  data:'id',
					  mRender: function(data,type,row){
						  var str = '';
							str += '<a href="'+window.contextRoot+ '/show/'+data+'/blog"><i class="fas fa-eye text-center" style="width:30px; height:30px;"></i></a>';
							return str;
					  }
				}
			]
		});
	}
	
	
	//end of the blog section
	
	
	//this is the datatable for the project this is the user interface
	
	var $table = $('#projectListTable');
	
	if($table.length){
		
		var jsonUrl = '';
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot+'/json/data/all/projects';
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/projects';
		}
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Projects','5 Projects','10 Projects','All']],
			pageLength: 5,
			ajax:{
				url: jsonUrl,
				dataSrc:''	
			},
			columns:[
				
				{
					data: 'code',
					bSortable: false,
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
	
	// dismissing the alert after 5 seconds
	var $alert = $('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000);
	}
	
	
	// toggle switch
	
	$('.switch input[type="checkbox"]').on('change',function(){
		var checkbox = $(this);
		var checked = checkbox.prop('checked');
		var dMsg = (checked)? 'you want yo active the project?':
			                  'you want to deactivate the project?';
		var value = checkbox.prop('value');
		
		bootbox.confirm({
			  size: 'medium',
			  title: 'project Activation & Deactivation',
			  message: dMsg,
			  callback: function(confirmed){
				  if(confirmed){
					  console.log(value);
					  bootbox.alert({
						 size: 'medium',
					     title: 'Information',
					     message: 'you are going to peform operation on project' + value
					  });
				  }else{
					  checkbox.prop('checked', !checked)
				  }
			  }
			  
		});
	});
	
	
	// data Table for admin  is this the backend table for the admin
	var $adminProjectTable = $('#adminProjectTable');
	
	if($adminProjectTable.length){
		var jsonUrl = window.contextRoot + '/json/data/admin/all/projects';
		
		$adminProjectTable.DataTable({
			lengthMenu: [[10,30,50,-1],['10 Projects','20 Projects','30 Projects','All']],
			pageLength: 10,
			ajax:{
				url: jsonUrl,
				dataSrc:''	
			},
			columns:[
				{
					data: 'id'
				},
				{
					data: 'code',
					bSortable: false,
					mRender: function(data,type,row){
						
						return '<img class="adminDataTableImg" src="'+window.contextRoot+'/resources/images/'+data+'.jpg" id="dataTableImages" />';
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
					data: 'active',
		            bSortable: false,
					mRender:function(data,type,row){
						var str = '';
					     str += '<label class="switch">';
						if(data){
							str += '<input type="checkbox" checked="checked" value="'+row.id+'" />';
						}else{
							str += '<input type="checkbox" value="'+row.id+'" />';
						}
						
						str += '<div class="slider"></div></label>';
						return str;
					} 
				},
				
				{
					data: 'id',
					bSortable: false,
					mRender: function(data,type,row){
						
						var str = '';
						
					  str += '<a href="'+window.contextRoot+'/manage/'+data+'/project" class="btn btn-warning">';
                      str += '<i class="fas fa-pencil-alt"></i></a>';
                      
                      return str;
					}
				}
			],
			initComplete: function(){
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change',function(){
					var checkbox = $(this);
					var checked = checkbox.prop('checked');
					var dMsg = (checked)? 'you want yo active the project?':
						                   'you want to deactivate the project?';
					var value = checkbox.prop('value');
					
					bootbox.confirm({
						  size: 'medium',
						  title: 'project Activation & Deactivation',
						  message: dMsg,
						  callback: function(confirmed){
							  if(confirmed){
								  console.log(value);
								  
								  var activationUrl = window.contextRoot + '/manage/project/' + value + '/activation';
								  
								  $.post(activationUrl, function(data){
									   bootbox.alert({
										  size: 'medium',
										  title: 'Information',
										  message: data
									   }); 
								  });
								  
								  bootbox.alert({
									 size: 'medium',
								     title: 'Information',
								     message: 'you are going to peform operation on project' + value
								  });
							  }else{
								  checkbox.prop('checked', !checked)
							  }
						  }
						  
					});
				});
			}
		});
			
	}
	
	
		
	
	// validateCategoryForm
	
	var $validateCategoryForm = $('validateCategoryForm');
	
	if($validateCategoryForm.length){
		
		$validateCategoryForm.validate({
			 
			rules: {
				name: {
					required: true,
					minlenght: 2
				},
				
				description: {
					required: true
				}
			},
			messages: {
				name: {
					required : 'please add the category name',
					minlength: 'The category name should not be less than 2 characters'
				},
				description:{
					required: 'please add a description for this category'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element){
				error.addClass('help-block');
			    error.insertAfter(element);
			    
			}
			
		});
		
	}
		
		//login form validation
		
$loginForm = $('#loginForm');
	
	if($loginForm.length) {
		
		$loginForm.validate({			
				rules: {
					username: {
						required: true,
						email: true
						
					},
					password: {
						required: true
					}				
				},
				messages: {					
					username: {
						required: 'Please enter your email!',
						email: 'Please enter a valid email address!'
					},
					password: {
						required: 'Please enter your password!'
					}					
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// Add the 'help-block' class to the error element
					error.addClass("help-block");
					
					// add the error label after the input element
					error.insertAfter(element);
				}				
			}
		
		);
		
	}
	     
	
	//sidebar blog 
	switch(menu){
	case 'about us':
		$('#about').addClass('active');
		break;
	case 'services':
		$('#services').addClass('active');
		break;
	case 'projects':
		$('#projects').addClass('active');
		break;
	case 'our blog':
		$('#blog').addClass('active');
		break;
	case 'contact us':
		$('#contact').addClass('active');
		break;
		default:
			if(menu == "Home" ) break;
			$('#home').addClass('active');
		    $('#a_'+menu).addClass('active');
			break;
	}
	
	
	
	
	
	//end blog table
	
	 var options = {
             zoom: 8,
             center:{lat:23.8962,lng:-29.4486}
         }
         var map = new google.maps.Map(document.getElementById('map'), options);
	
	 
	 
	     
});


