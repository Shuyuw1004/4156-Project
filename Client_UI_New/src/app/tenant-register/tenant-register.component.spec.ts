import {ComponentFixture, TestBed} from '@angular/core/testing';

import {TenantRegisterComponent} from './tenant-register.component';

describe('TenantRegisterComponent', () => {
  let component: TenantRegisterComponent;
  let fixture: ComponentFixture<TenantRegisterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TenantRegisterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TenantRegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
