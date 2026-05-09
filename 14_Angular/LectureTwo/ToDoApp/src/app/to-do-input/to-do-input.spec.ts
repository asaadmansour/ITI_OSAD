import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ToDoInput } from './to-do-input';

describe('ToDoInput', () => {
  let component: ToDoInput;
  let fixture: ComponentFixture<ToDoInput>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ToDoInput]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ToDoInput);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
