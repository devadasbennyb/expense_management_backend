import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import { UserData } from './user.model';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
})
export class UserComponent implements OnInit {
  formValue!: FormGroup;
  employeeData: any = [];
  userDataObj: UserData = new UserData();
  addSubmit: boolean;
  editSubmit: boolean;
  empId: boolean;
  constructor(private formbuilder: FormBuilder, private service: ApiService) {}
  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      empId: [''],
      firstName: [''],
      lastName: [''],
      address: [''],
      state: [''],
      mobile: [''],
      managerId: [''],
      emailId: [''],
      zip: [''],
      accno: [''],
      creditcardNo: [''],
      departId: [''],
    });
    this.getAllUsers();
  }
  getAllUsers(): void {
    this.service.getData('employee_details').subscribe({
      next: (res) => {
        this.employeeData = res;
      },
    });
  }
  clickAddUser() {
    this.addSubmit = true;
    this.editSubmit = false;
    this.empId = true;
  }
  addUser() {
    this.userDataObj.empId = this.formValue.value.empId;
    this.userDataObj.firstName = this.formValue.value.firstName;
    this.userDataObj.lastName = this.formValue.value.lastName;
    this.userDataObj.address = this.formValue.value.address;
    this.userDataObj.state = this.formValue.value.state;
    this.userDataObj.mobile = this.formValue.value.mobile;
    this.userDataObj.managerId = this.formValue.value.managerId;
    this.userDataObj.emailId = this.formValue.value.emailId;
    this.userDataObj.zip = this.formValue.value.zip;
    this.userDataObj.accno = this.formValue.value.accno;
    this.userDataObj.creditcardNo = this.formValue.value.creditcardNo;
    this.userDataObj.departId = this.formValue.value.departId;
    this.service.postUserData('employee_details', this.userDataObj).subscribe({
      next: (res) => {
        console.log(res);
        alert('User created successfully');
        this.getAllUsers();
      },
    });
  }
  editUser(data: any) {
    this.addSubmit = false;
    this.editSubmit = true;
    this.empId = false;
    this.userDataObj.empId = data.empId;
    this.formValue.controls['firstName'].setValue(data.firstName);
    this.formValue.controls['lastName'].setValue(data.lastName);
    this.formValue.controls['address'].setValue(data.address);
    this.formValue.controls['state'].setValue(data.state);
    this.formValue.controls['mobile'].setValue(data.mobile);
    this.formValue.controls['managerId'].setValue(data.managerId);
    this.formValue.controls['emailId'].setValue(data.emailId);
    this.formValue.controls['zip'].setValue(data.zip);
    this.formValue.controls['accno'].setValue(data.accno);
    this.formValue.controls['creditcardNo'].setValue(data.creditcardNo);
    this.formValue.controls['departId'].setValue(data.departId);
  }
  updateUser() {
    this.userDataObj.firstName = this.formValue.value.firstName;
    this.userDataObj.lastName = this.formValue.value.lastName;
    this.userDataObj.address = this.formValue.value.address;
    this.userDataObj.state = this.formValue.value.state;
    this.userDataObj.mobile = this.formValue.value.mobile;
    this.userDataObj.managerId = this.formValue.value.managerId;
    this.userDataObj.emailId = this.formValue.value.emailId;
    this.userDataObj.zip = this.formValue.value.zip;
    this.userDataObj.accno = this.formValue.value.accno;
    this.userDataObj.creditcardNo = this.formValue.value.creditcardNo;
    this.userDataObj.departId = this.formValue.value.departId;
    this.service
      .updateUserData(
        'employee_details/',
        this.userDataObj,
        this.userDataObj.empId
      )
      .subscribe({
        next: (res) => {
          console.log(res);
          alert('User updated successfully');
          this.getAllUsers();
        },
      });
  }
  deleteUser(data: any) {
    this.service.deleteUserData('employee_details/', data.empId).subscribe({
      next: (res) => {
        alert('User deleted successfully');
        this.getAllUsers();
      },
    });
  }
}
