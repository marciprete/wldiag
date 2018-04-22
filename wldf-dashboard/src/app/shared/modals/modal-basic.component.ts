import {Component, Input} from '@angular/core';

import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'ngbd-modal-basic',
  templateUrl: './modal-basic.html'
})
export class NgbdModalBasic {

  constructor(private modalService: NgbModal) {}

  open(content) {
    this.modalService.open(content, {size: 'lg'});
  }

}
