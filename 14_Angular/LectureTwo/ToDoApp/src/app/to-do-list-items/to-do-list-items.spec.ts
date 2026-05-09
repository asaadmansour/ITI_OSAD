import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToDoListItems } from './to-do-list-items';

describe('ToDoListItems', () => {
  let component: ToDoListItems;
  let fixture: ComponentFixture<ToDoListItems>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ToDoListItems]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToDoListItems);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
