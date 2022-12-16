import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealtorRegisterComponent } from './realtor-register.component';

describe('RealtorRegisterComponent', () => {
  let component: RealtorRegisterComponent;
  let fixture: ComponentFixture<RealtorRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RealtorRegisterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RealtorRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
