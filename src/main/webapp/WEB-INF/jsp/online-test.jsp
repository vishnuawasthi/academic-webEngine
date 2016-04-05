<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<table>

	<tr>
		<td>Question</td>
		<td>${examForm.question }</td>

	</tr>
	<tr>
		<td>A</td>
		<td>${examForm.optionA}</td>
	</tr>

	<tr>
		<td>B</td>
		<td>${examForm.optionB }</td>
	</tr>
	<tr>
		<td>C</td>
		<td>${examForm.optionC }</td>
	</tr>
	<tr>
		<td>D</td>
		<td>${examForm.optionD}</td>
	</tr>
	<tr>
		<td>Answer</td>
		<%-- <td><form:radiobuttons path="a" /></td> --%>
		<td><input type="radio" name="a"> A</input> <input type="radio"
			name="b"> B</input> <input type="radio" name="c"> C</input> <input
			type="radio" name="d"> D</input></td>
	</tr>
	<tr>
		<td>
			<button id="submit">Save</button> &nbsp;&nbsp;&nbsp;
			<button id="next">Next</button>
		</td>
	</tr>
</table>