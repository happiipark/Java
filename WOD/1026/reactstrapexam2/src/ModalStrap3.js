import { useState } from 'react';
import {Button, Modal, ModalHeader, ModalBody, ModalFooter} from 'reactstrap';

function ModalStrap3() {

    const [modal, setModal] = useState(false);
    const [nestedModal, setNestedModal] = useState(false);
    const toggle = () => { setModal(!modal)};
    const toggleNested = () => { setNestedModal(!nestedModal) };
    const toggleAll = () => { 
        setNestedModal(false) 
        setModal(false);
    };


    return(
        <div style={{width:"800px"}}>
            <Button color="danger" onClick={toggle}>첫 모달</Button>
            <Modal isOpen={modal} toggle={toggle}>
                <ModalHeader toggle={toggle}>"전청조 여자였던 것 알고 만났다"..남현희, '성전환 남성' 사실 털어놔</ModalHeader>
                <ModalBody>남씨는 26일 전씨를 둘러싼 각종 의혹 중 '남자가 아닌 여자'라는 것에 대해 여성조선과의 인터뷰에서 입을 열었다. 전씨는 앞서 남씨 스토킹 혐의로 현행범 체포된 이후 경찰 신원조회 과정에서 주민등록상 '여성'인 것이 드러난 바 있다.
                <br/>
                <Button color="success"  onClick={toggleNested}>두번째 모달</Button>
                <Modal isOpen={nestedModal} toggle={toggleNested}>
                    <ModalHeader >남씨 "교제 전부터 성전환 수술 받은 사실 알아"</ModalHeader>
                    <ModalBody>
                    남씨는 또 전씨가 건네준 임신테스트기로 검사하면서 그동안 자신이 임신한 줄 알고 있었다고 토로했다. 전씨가 10여개의 임신테스트기를 건네면서 임신을 확인하도록 했는데, 매번 두줄(양성 반응)이 나왔다는 것이다.
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={toggleNested}>닫기</Button>
                        <Button color="secondary" onClick={toggleAll}>전체닫기</Button>
                    </ModalFooter>
                </Modal>
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" onClick={toggle}>처리</Button>
                    <Button color="secondary" onClick={toggle}>취소</Button>
                </ModalFooter>
            </Modal>
        </div>
    )

}

export default ModalStrap3;