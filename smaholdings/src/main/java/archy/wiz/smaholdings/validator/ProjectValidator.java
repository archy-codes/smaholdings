package archy.wiz.smaholdings.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import archy.wiz.smaholdingsbackend.dto.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Project project = (Project) target;
		
		//checking if the file was selected
		if(project.getFile() == null || project.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null,"please select an image to upload!");
			return;
		}
		if(! (
				project.getFile().getContentType().equals("image/jpeg") ||
				project.getFile().getContentType().equals("image/png") ||
				project.getFile().getContentType().equals("image/gif")
				
				))
		    {
			errors.rejectValue("file", null, "please use only image file for upload");
			return;
			
		}

	}

}
