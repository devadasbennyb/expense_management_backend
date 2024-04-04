import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpensesRulesComponent } from './expenses-rules.component';

describe('ExpensesRulesComponent', () => {
  let component: ExpensesRulesComponent;
  let fixture: ComponentFixture<ExpensesRulesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpensesRulesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpensesRulesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
