import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfullResetPwdComponent } from './successfull-reset-pwd.component';

describe('SuccessfullResetPwdComponent', () => {
  let component: SuccessfullResetPwdComponent;
  let fixture: ComponentFixture<SuccessfullResetPwdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuccessfullResetPwdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SuccessfullResetPwdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
