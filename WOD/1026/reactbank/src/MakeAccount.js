import { Form, FormGroup, Col, Label, Input, Button } from 'reactstrap';


function MakeAccount() {
    return(
        <div style={{width:"600px" ,border:"1px solid", margin:"20px auto"}}> 
            <h2 className="mt-4">계좌개설</h2>
            <Form className='mt-4 ml-4'>
                <FormGroup row>
                    <Label for="id" sm={2} >계좌번호</Label>
                    <Col sm={8}>
                        <Input type="text" name="id" id="id" />
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Label for="name" sm={2}>이름</Label>
                    <Col sm={8}>
                        <Input type="text" name="name" id="name" />
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Label for="withdraw" sm={2}>입금액</Label>
                    <Col sm={8}>
                        <Input type="text" name="withdraw" id="withdraw"  />
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Label sm={2}>계좌종류</Label>
                    <Col sm={8}>
                    <FormGroup check>
                        <Input type="radio" name="radio" id="normal" />
                        <Label check for="normal" className='mr-5'>일반 계좌</Label>
                        
                        <Input type="radio" name="radio" id="special" />
                        <Label check for="special">특수 계좌</Label>
                    </FormGroup>
                    </Col>
                </FormGroup>
                <FormGroup row>
                    <Label for="withdraw" sm={2}>등급</Label>
                    <Col sm={8}>
                        <Input type="select" name="select" id="select">
                            <option>VIP</option>
                            <option>Gold</option>
                            <option>Silver</option>
                            <option>Normal</option>
                        </Input>
                    </Col>
                </FormGroup>
                <FormGroup row>
                    
                    <Col sm={10}>
                        {/* <Button color="primary">계좌개설</Button> */}
                        <Input type="button" value="계좌개설" style={{background:"#007bff", color:"white"}}></Input>
                    </Col>
                </FormGroup>
            </Form>
        </div>
    )
}

export default MakeAccount;