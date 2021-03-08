import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeirdsUpdateDialogComponent } from './seirds-update-dialog.component';

describe('SeirdsUpdateDialogComponent', () => {
  let component: SeirdsUpdateDialogComponent;
  let fixture: ComponentFixture<SeirdsUpdateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeirdsUpdateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeirdsUpdateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
