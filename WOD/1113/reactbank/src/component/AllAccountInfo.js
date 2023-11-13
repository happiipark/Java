import {useState, useEffect} from 'react';
import { Table } from 'reactstrap';

const AllAccountInfo = () => {
    const formStyle = {width:'600px', margin:'20px auto', border:'1px solid lightgray', padding:'30px', borderRadius:'7px'}
    const [accs, setAccs] = useState([]);

    useEffect(
        ()=> {
            //backend에 데이터 요청하여 전체계좌목록을 가져온다.
            let raccs = [
                {id:'1001',name:'홍길동',balance:100000,type:'normal',grade:''},
                {id:'1002',name:'김길동',balance:200000,type:'special',grade:'VIP'},
                {id:'1003',name:'고길동',balance:300000,type:'special',grade:'Gold'},
                {id:'1004',name:'하길동',balance:400000,type:'normal',grade:''},
                {id:'1005',name:'장길동',balance:500000,type:'special',grade:'Silver'},
            ]
            setAccs([...raccs]);
        },[]
    )

    return(
        <div style={formStyle}>
            <h4 style={{textAlign:'center'}}>전체계좌조회</h4><br/>
            <Table bordered>
                <thead>
                <tr><th>계좌번호</th><th>이름</th><th>잔액</th><th>종류</th><th>등급</th></tr>
                </thead>
                <tbody>
                    {
                        accs.map(acc=> {
                            return(<tr key={acc.id}>
                                <td>{acc.id}</td>
                                <td>{acc.name}</td>
                                <td>{acc.balance}</td>
                                <td>{acc.type}</td>
                                <td>{acc.grade}</td>
                            </tr>)
                        })
                    }        
                </tbody>

            </Table>
        </div>
    )
}

export default AllAccountInfo;