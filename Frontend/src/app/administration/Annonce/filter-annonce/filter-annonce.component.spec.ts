import {ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterAnnonceComponent} from './filter-annonce.component';

describe('FilterAnnonceComponent', () => {
  let component: FilterAnnonceComponent;
  let fixture: ComponentFixture<FilterAnnonceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterAnnonceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterAnnonceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
