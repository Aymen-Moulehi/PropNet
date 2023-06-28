import {ComponentFixture, TestBed} from '@angular/core/testing';

import {FilterForumComponent} from './filter-forum.component';

describe('FilterForumComponent', () => {
  let component: FilterForumComponent;
  let fixture: ComponentFixture<FilterForumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FilterForumComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FilterForumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
