
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="wrapper">
<div class="rounded">
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   RoleType   </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.roleName }   </div>
		<a href="editUserDetail?id=${userDetals.id}">Edit Detail</a>
	</div>
	
	
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   FirstName   </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.firstName }   </div>
	</div>
	
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   LastName   </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.lastName }   </div>
	</div>
	
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   Email  </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.email}   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   ContactNumber  </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.mobile }   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   UserName  </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.username }  </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   AddressLine1  </div>
		<div class=" col-sm-4 col-md-4">  ${userDetals.addressLine1 }   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   AddressLine2  </div>
		<div class=" col-sm-4 col-md-4"> ${userDetals.addressLine2 }   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   City </div>
		<div class=" col-sm-4 col-md-4">  ${userDetals.city}   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   PinCode  </div>
		<div class=" col-sm-4 col-md-4">${userDetals.pincode}     </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   State  </div>
		<div class=" col-sm-4 col-md-4">   ${userDetals.state}   </div>
	</div>
	
	<div class="row">
		<div class="col-sm-offset-2 col-sm-4 col-md-4">   Country  </div>
		<div class=" col-sm-4 col-md-4">   ${userDetals.country}    </div>
	</div>
	
	</div>
</div>