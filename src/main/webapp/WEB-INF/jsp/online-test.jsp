<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="wrapper">
	<div class="rounded">
		<div class="row">
			<div class="col-md-12">Question 1. When India got freedom from
				British ?</div>
		</div>
		<hr>
		<div class="row"><div class="col-md-12"><span>Available Choice :</span> </div> </div>
		
		<div class="row">
			<div class="col-md-4">A</div>
			<div class="col-md-8">${examForm.optionA}</div>
		</div>
		<div class="row">
			<div class="col-md-4">B</div>
			<div class="col-md-8">${examForm.optionB}</div>
		</div>
		<div class="row">
			<div class="col-md-4">C</div>
			<div class="col-md-8">${examForm.optionC}</div>
		</div>
		<div class="row">
			<div class="col-md-4">D</div>
			<div class="col-md-8">${examForm.optionD}</div>
		</div>
		<div class="row">
			<div class="col-md-offset-0 col-md-2"> Answers :</div>
			<div class="col-md-offset-0 col-md-11">
			<form class="example-awaser-form">
			<input class="inline-inputbox"  type="radio"  value="a" name="answer"> A</input> 
			<input class="inline-inputbox"  type="radio" name="answer" value="b"> B</input> 
			<input class="inline-inputbox"  type="radio"  name="answer" value="c"> C</input> 
			<input class="inline-inputbox"  type="radio" name="answer" value="d"> D</input>
			</form>
		</div>
		</div>
		<div class="row">
		<div class="col-md-12"><button id="submit">Save</button> &nbsp;&nbsp;&nbsp;
					<button id="next">Next</button> </div>
		</div>
	</div>
</div>