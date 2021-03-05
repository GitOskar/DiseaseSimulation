import { TestBed } from '@angular/core/testing';

import { SeirdsService } from './seirds.service';

describe('SeirdsService', () => {
  let service: SeirdsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SeirdsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
