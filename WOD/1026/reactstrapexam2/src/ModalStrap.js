import { useState} from 'react';
import {Button, Modal, ModalHeader, ModalBody, ModalFooter} from 'reactstrap';

function ModalStrap(){

    const [open, setOpen] = useState(false);



    return(
        <div>
            <Button color="danger" onClick={(()=> setOpen(true))}>모달</Button>
            <Modal isOpen={open} toggle={()=>setOpen(!open)}>
                <ModalHeader toggle={()=>setOpen(!open)}>Modal title</ModalHeader>
                <ModalBody>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit,
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={()=>setOpen(!open)}>확인</Button>{' '}
                    <Button color="secondary" onClick={()=>setOpen(!open)}>취소</Button>{' '}
                </ModalFooter>
            </Modal>
        </div>
    )
}

export default ModalStrap;