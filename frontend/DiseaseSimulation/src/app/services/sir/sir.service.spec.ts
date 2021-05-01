import { TestBed } from '@angular/core/testing';

import { SirService } from './sir.service';

describe('SirService', () => {
  let service: SirService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SirService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
