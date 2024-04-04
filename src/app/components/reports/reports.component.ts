import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import { ReportsData } from './reports.model';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css'],
})
export class ReportsComponent implements OnInit {
  formValue!: FormGroup;
  reportData: any = [];
  ReportDataObj: ReportsData = new ReportsData();
  addSubmit: boolean;
  editSubmit: boolean;
  id: boolean;
  constructor(private formbuilder: FormBuilder, private service: ApiService) {}
  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      id: [''],
      statusOfExpense: [''],
      description: [''],
      amount: [''],
    });
    this.getAllReports();
  }
  getAllReports(): void {
    this.service.getData('report_table').subscribe({
      next: (res) => {
        this.reportData = res;
      },
    });
  }

  clickAddReport() {
    this.addSubmit = true;
    this.editSubmit = false;
    this.id = true;
  }
  addUser() {
    this.ReportDataObj.id = this.formValue.value.id;
    this.ReportDataObj.statusOfExpense = this.formValue.value.statusOfExpense;
    this.ReportDataObj.description = this.formValue.value.description;
    this.ReportDataObj.amount = this.formValue.value.amount;
    this.service.postReportsData('report_table', this.ReportDataObj).subscribe({
      next: (res) => {
        console.log(res);
        alert('User created successfully');
        this.getAllReports();
      },
    });
  }
  editUser(data: any) {
    this.addSubmit = false;
    this.editSubmit = true;
    this.id = false;
    this.ReportDataObj.id = data.id;
    this.formValue.controls['statusOfExpense'].setValue(data.statusOfExpense);
    this.formValue.controls['description'].setValue(data.description);
    this.formValue.controls['amount'].setValue(data.amount);
  }
  updateUser() {
    this.ReportDataObj.statusOfExpense = this.formValue.value.statusOfExpense;
    this.ReportDataObj.description = this.formValue.value.description;
    this.ReportDataObj.amount = this.formValue.value.amount;
    this.service
      .updateReportsData(
        'report_table/',
        this.ReportDataObj,
        this.ReportDataObj.id
      )
      .subscribe({
        next: (res) => {
          console.log(res);
          alert('User updated successfully');
          this.getAllReports();
        },
      });
  }
  deleteUser(data: any) {
    this.service.deleteReportsData('report_table/', data.id).subscribe({
      next: (res) => {
        alert('User deleted successfully');
        this.getAllReports();
      },
    });
  }
}
