import { useState} from 'react';
import {ButtonDropdown, DropdownToggle, DropdownMenu, DropdownItem} from 'reactstrap';

function DropdownStrap(){

    const [open, setOpen] = useState(true);


    return(
        <>
        <ButtonDropdown isOpen={open} toggle={() => setOpen(!open)}>
            <DropdownToggle caret color="success" size="normal">버튼 Dropdown</DropdownToggle>
            <DropdownMenu>
                <DropdownItem header>헤더</DropdownItem>
                <DropdownItem divider/>
                <DropdownItem disabled>비활성화 버튼</DropdownItem>
                <a href="http://daum.net">
                    <DropdownItem>다음 사이트로 이동</DropdownItem>
                </a>
                <DropdownItem onClick={()=>alert('Alert버튼')}>Alert 버튼</DropdownItem>
            </DropdownMenu>
        </ButtonDropdown>
        </>
    )
}

export default DropdownStrap;