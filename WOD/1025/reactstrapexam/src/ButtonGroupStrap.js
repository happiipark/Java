
import { useState } from 'react';
import {Button, ButtonGroup, ButtonDropdown, DropdownItem, DropdownToggle, DropdownMenu} from 'reactstrap';

function ButtonGroupStrap(){
    const [number,setNumber] = useState(0);
    const [open, setOpen] = useState(false);
    return(
        <>
        <ButtonGroup>
            <Button>&lt;</Button>
            <Button>1</Button>
            <Button>2</Button>
            <Button>3</Button>
            <Button>4</Button>
            <Button>5</Button>
            <Button>&gt;</Button>
        </ButtonGroup>
        <br/><br/>
        <ButtonGroup>
            <Button onClick={() => setNumber(number-1)}>-</Button>
            <Button disabled>{number}</Button>
            <Button onClick={() => setNumber(number+1)}>+</Button>
        </ButtonGroup>
        <br/><br/>
        <ButtonGroup>
            <Button>1</Button>
            <Button>2</Button>
            <ButtonDropdown isOpen={open} toggle={()=>setOpen(!open)}>
                <DropdownToggle caret>
                    선택
                </DropdownToggle>
                <DropdownMenu>
                    <DropdownItem>3</DropdownItem>
                    <DropdownItem>4</DropdownItem>
                </DropdownMenu>
            </ButtonDropdown>
        </ButtonGroup>
        </>
    )
}

export default ButtonGroupStrap;