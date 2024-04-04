import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { expenseData } from '../components/expenses/expenses.model';
import { ReportsData } from '../components/reports/reports.model';
import { SignUpData } from '../components/sign-up-page/sign-up.model';
import { TripsData } from '../components/trips/trips.model';
import { UserData } from '../components/user/user.model';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private HOST: string = 'http://127.0.0.1:8000/';

  constructor(private http: HttpClient) {}

  getData(endpoint: string) {
    return this.http.get(`${this.HOST + endpoint}`);
  }

  //Sign up Component
  postData(endpoint: string, body: any) {
    return this.http.post(`${this.HOST + endpoint}`, body);
  }

  postSignUpData(endpoint: string, signUpObj: SignUpData) {
    return this.http.post(`${this.HOST + endpoint}`, signUpObj);
  }

  //User component
  postUserData(endpoint: string, userDataObj: UserData) {
    return this.http.post(`${this.HOST + endpoint}`, userDataObj);
  }

  updateUserData(endpoint: string, userDataObj: UserData, empId: number) {
    return this.http.put(`${this.HOST + endpoint + empId}`, userDataObj);
  }

  deleteUserData(endpoint: string, empId: number) {
    return this.http.delete(`${this.HOST + endpoint + empId}`);
  }

  // Expense Component
  postExpenseData(endpoint: string, expenseDataObj: expenseData) {
    return this.http.post(`${this.HOST + endpoint}`, expenseDataObj);
  }

  updateExpenseData(
    endpoint: string,
    expenseDataObj: expenseData,
    empId: number
  ) {
    return this.http.put(`${this.HOST + endpoint + empId}`, expenseDataObj);
  }

  deleteExpenseData(endpoint: string, empId: number) {
    return this.http.delete(`${this.HOST + endpoint + empId}`);
  }

  //Trips Componenet
  postTripsData(endpoint: string, tripsDataObj: TripsData) {
    return this.http.post(`${this.HOST + endpoint}`, tripsDataObj);
  }

  updateTripsData(endpoint: string, tripDataObj: TripsData, tripId: number) {
    return this.http.put(`${this.HOST + endpoint + tripId}`, tripDataObj);
  }

  deleteTripsData(endpoint: string, tripId: number) {
    return this.http.delete(`${this.HOST + endpoint + tripId}`);
  }

  //Reports Componenet
  postReportsData(endpoint: string, ReportDataObj: ReportsData) {
    return this.http.post(`${this.HOST + endpoint}`, ReportDataObj);
  }

  updateReportsData(endpoint: string, ReportDataObj: ReportsData, id: number) {
    return this.http.put(`${this.HOST + endpoint + id}`, ReportDataObj);
  }

  deleteReportsData(endpoint: string, id: number) {
    return this.http.delete(`${this.HOST + endpoint + id}`);
  }

  // create post method
  post(data: any) {
    return this.http.post<any>('http://localhost:3000/posts', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  //Get data using GET method
  get() {
    return this.http.get<any>('http://localhost:3000/posts').pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  //update  using PUT method
  update(data: any, id: number) {
    return this.http.put<any>('http://localhost:3000/posts/' + id, data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  //Delete  using Delete method
  delete(id: number) {
    return this.http.delete<any>('http://localhost:3000/posts/' + id).pipe(
      map((res: any) => {
        return res;
      })
    );
  }
}
