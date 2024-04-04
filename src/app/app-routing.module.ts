import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignInPageComponent } from './components/sign-in-page/sign-in-page.component';
import { ExpensesComponent } from './components/expenses/expenses.component';
import { TripsComponent } from './components/trips/trips.component';
import { ReportsComponent } from './components/reports/reports.component';
import { SettingsComponent } from './components/settings/settings.component';
import { UserComponent } from './components/user/user.component';
import { PaymentTypesComponent } from './components/payment-types/payment-types.component';
import { SignUpPageComponent } from './components/sign-up-page/sign-up-page.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
import { GooglePageComponent } from './components/google-page/google-page.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SuccessfullResetPwdComponent } from './components/successfull-reset-pwd/successfull-reset-pwd.component';
import { SuccessfullSignUpComponent } from './components/successfull-sign-up/successfull-sign-up.component';
import { AdvancesComponent } from './components/advances/advances.component';
import { AdminComponent } from './components/admin/admin.component';
import { GroupsComponent } from './components/groups/groups.component';
import { RolesComponent } from './components/roles/roles.component';
import { ExpensesRulesComponent } from './components/expenses-rules/expenses-rules.component';
import { MileageComponent } from './components/mileage/mileage.component';
import { IntegrationsComponent } from './components/integrations/integrations.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'sign-in-page',
    pathMatch: 'full',
  },
  {
    path: 'sign-in-page',
    component: SignInPageComponent,
  },
  {
    path: 'sign-up-page',
    component: SignUpPageComponent,
  },
  {
    path: 'forget-password',
    component: ForgetPasswordComponent,
  },
  {
    path: 'google-page',
    component: GooglePageComponent,
  },
  {
    path: 'home-page',
    component: HomePageComponent,
  },
  {
    path: 'successfull-reset-pwd',
    component: SuccessfullResetPwdComponent,
  },
  {
    path: 'successfull-sign-up',
    component: SuccessfullSignUpComponent,
  },
  {
    path: 'expenses',
    component: ExpensesComponent,
  },
  {
    path: 'trips',
    component: TripsComponent,
  },
  {
    path: 'reports',
    component: ReportsComponent,
  },
  {
    path: 'settings',
    component: SettingsComponent,
  },
  {
    path: 'advances',
    component: AdvancesComponent,
  },
  {
    path: 'admin',
    component: AdminComponent,
  },
  {
    path: 'user',
    component: UserComponent,
  },
  {
    path: 'groups',
    component: GroupsComponent,
  },
  {
    path: 'roles',
    component: RolesComponent,
  },
  {
    path: 'payment-types',
    component: PaymentTypesComponent,
  },
  {
    path: 'expenses-rules',
    component: ExpensesRulesComponent,
  },
  {
    path: 'mileage',
    component: MileageComponent,
  },
  {
    path: 'integrations',
    component: IntegrationsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
