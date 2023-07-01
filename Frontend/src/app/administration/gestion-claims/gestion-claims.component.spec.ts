import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionClaimsComponent } from './gestion-claims.component';

describe('GestionClaimsComponent', () => {
  let component: GestionClaimsComponent;
  let fixture: ComponentFixture<GestionClaimsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GestionClaimsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionClaimsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
