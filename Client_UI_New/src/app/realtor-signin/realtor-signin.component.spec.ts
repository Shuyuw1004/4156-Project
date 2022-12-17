import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealtorSigninComponent } from './realtor-signin.component';

describe('RealtorSigninComponent', () => {
  let component: RealtorSigninComponent;
  let fixture: ComponentFixture<RealtorSigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RealtorSigninComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RealtorSigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
