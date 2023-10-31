import { Button, Modal, ModalHeader, ModalBody, ModalFooter, Input, Label, Form, FormGroup} from 'reactstrap';
import { useState } from 'react';

function ModalStrap2() {

    const [open, setOpen] = useState(false);
    const toggle = () => {setOpen(!open)};
    const [fruit, setFruit] = useState('banana');
    const change = (e) => {
        console.log(e.target.value);
        setFruit(e.target.value);
    }

    const send = () => {
        console.log("데이터 전송 처리 ");
        toggle();
    }


    return(
        <div style={{width:"800px"}}>
            <Form inline onSubmit={(e)=>e.preventDefault()}>
                <FormGroup>
                    <Label>과일선택</Label>&nbsp;&nbsp;
                    <Input type="select" onChange={change}>
                        <option value="banana">바나나</option>
                        <option value="apple">사과</option>
                        <option value="orange">오렌지</option>
                    </Input>
                </FormGroup>
                &nbsp;&nbsp;
                <Button color="primary" onClick={toggle}>전송</Button>
            </Form>
            <br/><br/>
            <Modal isOpen={open} toggle={()=>toggle()}>
                <ModalHeader toggle={toggle}>
                전송 여부 확인
                </ModalHeader>
                <ModalBody>
                    {fruit}을 선택하셨습니다.<br/>
                    전송하시겠습니까?
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={send}>전송</Button>
                    <Button color="secondary" onClick={()=>setOpen(false)}>취소</Button>
                </ModalFooter>
            </Modal>
        </div>
    )
}

export default ModalStrap2;