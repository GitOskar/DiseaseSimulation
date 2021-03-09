import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SirUpdateDialogComponent } from './sir-update-dialog.component';

describe('SirUpdateDialogComponent', () => {
  let component: SirUpdateDialogComponent;
  let fixture: ComponentFixture<SirUpdateDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SirUpdateDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SirUpdateDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
