import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from 'src/app/services/api.service';
import { TripsData } from './trips.model';

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css'],
})
export class TripsComponent implements OnInit {
  formValue!: FormGroup;
  tripDetails: any = [];
  tripDataObj: TripsData = new TripsData();
  addSubmit: boolean;
  editSubmit: boolean;
  tripId: boolean;
  empId: boolean;
  constructor(private formbuilder: FormBuilder, private service: ApiService) {}
  ngOnInit(): void {
    this.formValue = this.formbuilder.group({
      tripId: [''],
      empId: [''],
      tripName: [''],
      startDate: [''],
      endDate: [''],
      fromLocation: [''],
      toLocation: [''],
      budget: [''],
    });
    this.getAllTrips();
  }
  getAllTrips(): void {
    this.service.getData('trip_details').subscribe({
      next: (res) => {
        this.tripDetails = res;
      },
    });
  }

  clickAddTrip() {
    this.addSubmit = true;
    this.editSubmit = false;
    this.tripId = true;
    this.empId = true;
  }
  addTrip() {
    this.tripDataObj.tripId = this.formValue.value.tripId;
    this.tripDataObj.empId = this.formValue.value.empId;
    this.tripDataObj.tripName = this.formValue.value.tripName;
    this.tripDataObj.startDate = this.formValue.value.startDate;
    this.tripDataObj.endDate = this.formValue.value.endDate;
    this.tripDataObj.fromLocation = this.formValue.value.fromLocation;
    this.tripDataObj.toLocation = this.formValue.value.toLocation;
    this.tripDataObj.budget = this.formValue.value.budget;

    this.service.postTripsData('trip_details', this.tripDataObj).subscribe({
      next: (res) => {
        console.log(res);
        alert('User created successfully');
        this.getAllTrips();
      },
    });
  }
  editTrip(data: any) {
    this.addSubmit = false;
    this.editSubmit = true;
    this.tripId = false;
    this.empId = false;
    this.tripDataObj.tripId = data.tripId;
    this.formValue.controls['tripName'].setValue(data.tripName);
    this.formValue.controls['startDate'].setValue(data.startDate);
    this.formValue.controls['endDate'].setValue(data.endDate);
    this.formValue.controls['fromLocation'].setValue(data.fromLocation);
    this.formValue.controls['toLocation'].setValue(data.toLocation);
    this.formValue.controls['budget'].setValue(data.budget);
  }
  updateTrip() {
    this.tripDataObj.tripName = this.formValue.value.tripName;
    this.tripDataObj.startDate = this.formValue.value.startDate;
    this.tripDataObj.endDate = this.formValue.value.endDate;
    this.tripDataObj.fromLocation = this.formValue.value.fromLocation;
    this.tripDataObj.toLocation = this.formValue.value.toLocation;
    this.tripDataObj.budget = this.formValue.value.budget;
    this.service
      .updateTripsData(
        'trip_details/',
        this.tripDataObj,
        this.tripDataObj.tripId
      )
      .subscribe({
        next: (res) => {
          console.log(res);
          alert('User updated successfully');
          this.getAllTrips();
        },
      });
  }
  deleteTrip(data: any) {
    this.service.deleteTripsData('trip_details/', data.tripId).subscribe({
      next: (res) => {
        alert('User deleted successfully');
        this.getAllTrips();
      },
    });
  }
}
