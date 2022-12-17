import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealtorUserHomeComponent } from './realtor-user-home.component';

describe('RealtorUserHomeComponent', () => {
  let component: RealtorUserHomeComponent;
  let fixture: ComponentFixture<RealtorUserHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RealtorUserHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RealtorUserHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
