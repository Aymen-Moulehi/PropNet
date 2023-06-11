import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAnnoncesComponent } from './list-annonces.component';

describe('ListAnnoncesComponent', () => {
  let component: ListAnnoncesComponent;
  let fixture: ComponentFixture<ListAnnoncesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListAnnoncesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAnnoncesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
