import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { SignUpData } from '../sign-up-page/sign-up.model';
import { ApiService } from 'src/app/services/api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in-page',
  templateUrl: './sign-in-page.component.html',
  styleUrls: ['./sign-in-page.component.css'],
})
export class SignInPageComponent implements OnInit {
  logInForm!: FormGroup;
  signUpObj: SignUpData = new SignUpData();
  constructor(
    private router: Router,
    private service: ApiService,
    private formBuilder: FormBuilder,
    private _http: HttpClient
  ) {}

  ngOnInit(): void {
    this.logInForm = this.formBuilder.group({
      emailId: [''],
      password: [''],
    });
  }

  logIn() {
    this._http.get<any>('http://127.0.0.1:8000/emp_registration').subscribe(
      (res) => {
        const user = res.find((a: any) => {
          return (
            a.emailId == this.logInForm.value.emailId &&
            a.password == this.logInForm.value.password
          );
        });
        if (user) {
          alert('Login Successful');
          this.logInForm.reset();
          this.router.navigate(['home-page']);
        } else {
          alert('User Not Found !!');
        }
      },
      (err) => {
        alert('something went wrong');
      }
    );
  }
}
