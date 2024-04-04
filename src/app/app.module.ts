import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { ExpensesComponent } from './components/expenses/expenses.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { TripsComponent } from './components/trips/trips.component';
import { ReportsComponent } from './components/reports/reports.component';
import { SettingsComponent } from './components/settings/settings.component';
import { UserComponent } from './components/user/user.component';
import { PaymentTypesComponent } from './components/payment-types/payment-types.component';
import { SignUpPageComponent } from './components/sign-up-page/sign-up-page.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
import { GooglePageComponent } from './components/google-page/google-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SuccessfullSignUpComponent } from './components/successfull-sign-up/successfull-sign-up.component';
import { SuccessfullResetPwdComponent } from './components/successfull-reset-pwd/successfull-reset-pwd.component';
import { AdvancesComponent } from './components/advances/advances.component';
import { AdminComponent } from './components/admin/admin.component';
import { GroupsComponent } from './components/groups/groups.component';
import { RolesComponent } from './components/roles/roles.component';
import { ExpensesRulesComponent } from './components/expenses-rules/expenses-rules.component';
import { MileageComponent } from './components/mileage/mileage.component';
import { IntegrationsComponent } from './components/integrations/integrations.component';
import { ApiService } from './services/api.service';

@NgModule({
  declarations: [
    AppComponent,
    SignInPageComponent,
    SignUpPageComponent,
    ForgetPasswordComponent,
    GooglePageComponent,
    HomePageComponent,
    SuccessfullSignUpComponent,
    SuccessfullResetPwdComponent,
    ExpensesComponent,
    TripsComponent,
    ReportsComponent,
    SettingsComponent,
    AdvancesComponent,
    AdminComponent,
    UserComponent,
    GroupsComponent,
    RolesComponent,
    PaymentTypesComponent,
    ExpensesRulesComponent,
    MileageComponent,
    IntegrationsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
  ],
  providers: [ApiService],
  bootstrap: [AppComponent],
})
export class AppModule {}
