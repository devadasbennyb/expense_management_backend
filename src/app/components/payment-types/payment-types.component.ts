import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-payment-types',
  templateUrl: './payment-types.component.html',
  styleUrls: ['./payment-types.component.css'],
})
export class PaymentTypesComponent implements OnInit {
  paymentTypes: any = [];
  constructor(private service: ApiService) {}

  ngOnInit(): void {
    this.getAllPaymentTypes();
  }

  getAllPaymentTypes(): void {
    this.service.getData('payment_methods').subscribe({
      next: (res) => {
        this.paymentTypes = res;
      },
    });
  }
}
