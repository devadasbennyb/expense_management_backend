import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';
import { SignUpData } from './sign-up.model';
@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css'],
})
export class SignUpPageComponent implements OnInit {
  public user = { firstName: null };
  formValue!: FormGroup;
  UserDetails: any = [];
  signUpDataObj: SignUpData = new SignUpData();
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private service: ApiService
  ) {}
  ngOnInit(): void {
    this.formValue = this.formBuilder.group({
      firstName: [''],
      lastName: [''],
      empId: [''],
      companyName: [''],
      mobilenumber: [''],
      emailId: [''],
      Designation: [''],
      password: [''],
      confirmPassword: [''],
    });
  }
  getAllUsers(): void {
    this.service.getData('expense_details').subscribe({
      next: (res) => {
        this.UserDetails = res;
      },
    });
  }
  signUp() {
    this.signUpDataObj.firstName = this.formValue.value.firstName;
    this.signUpDataObj.lastName = this.formValue.value.lastName;
    this.signUpDataObj.empId = this.formValue.value.empId;
    this.signUpDataObj.companyName = this.formValue.value.companyName;
    this.signUpDataObj.mobilenumber = this.formValue.value.mobilenumber;
    this.signUpDataObj.emailId = this.formValue.value.emailId;
    this.signUpDataObj.Designation = this.formValue.value.Designation;
    this.signUpDataObj.password = this.formValue.value.password;
    this.signUpDataObj.confirmPassword = this.formValue.value.confirmPassword;
    this.service.postData('emp_registration', this.signUpDataObj).subscribe({
      next: (res) => {
        console.log(res);
        alert('Registered  successfully');
        this.formValue.reset();
        this.router.navigate(['sign-in-page']);
      },
    });
  }
}
