function doValidation(frm) {
  frm.vFlag.value = "yes";
	
  // Empty old form validation errors
  document.getElementById("enameErr").innerHTML = "";
  document.getElementById("jobErr").innerHTML = "";
  document.getElementById("salErr").innerHTML = "";
  //document.getElementById("deptNoErr").innerHTML = "";

  // Read form component values
  let name = frm.ename.value;
  let desg = frm.job.value;
  let salary = frm.sal.value;
  //let deptNo = frm.deptNo.value;
  let isValid = true;

  // Write the client-side form validation logic
  if (name == "") { // Required rule
    isValid = false;
    document.getElementById("enameErr").innerHTML = "Employee name is required frm side";
  } else if (name.length < 5 || name.length > 15) { // Length rule
    isValid = false;
    document.getElementById("enameErr").innerHTML = "Employee name should be between 5 to 15 chars frm";
  }

  if (desg == "") {
    isValid = false;
    document.getElementById("jobErr").innerHTML = "Employee job is required frm";
  } else if (desg.length < 5 || desg.length > 15) {
    isValid = false;
    document.getElementById("jobErr").innerHTML = "Employee job should be between frm";
  }

  if (salary == "") {
    isValid = false;
    document.getElementById("salErr").innerHTML = "Employee salary is required frm";
  } else if (isNaN(salary)) {
    isValid = false;
    document.getElementById("salErr").innerHTML = "Employee salary should be numeric value frm";
  }

  //if (deptNo == "") {
   // isValid = false;
   // document.getElementById("deptNoErr").innerHTML = "Employee department number is required frm";
  //}

  return isValid;
}
