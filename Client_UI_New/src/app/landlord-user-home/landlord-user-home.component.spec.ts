import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LandlordUserHomeComponent } from './landlord-user-home.component';

describe('LandlordUserHomeComponent', () => {
  let component: LandlordUserHomeComponent;
  let fixture: ComponentFixture<LandlordUserHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LandlordUserHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LandlordUserHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
