import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsAnnonceComponent } from './details-annonce.component';

describe('DetailsAnnonceComponent', () => {
  let component: DetailsAnnonceComponent;
  let fixture: ComponentFixture<DetailsAnnonceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailsAnnonceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsAnnonceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
