import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandlordSigninComponent } from './landlord-signin.component';

describe('LandlordSigninComponent', () => {
  let component: LandlordSigninComponent;
  let fixture: ComponentFixture<LandlordSigninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandlordSigninComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandlordSigninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
