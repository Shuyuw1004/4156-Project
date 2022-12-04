import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TenantUpdateComponent } from './tenant-update.component';

describe('TenantRegisterComponent', () => {
  let component: TenantUpdateComponent;
  let fixture: ComponentFixture<TenantUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TenantUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TenantUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
