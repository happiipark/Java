import { useState } from 'react';
import { ListGroup, ListGroupItem, Badge, ListGroupItemHeading, ListGroupItemText } from 'reactstrap';

function ListGroupStrap(){
    return(
        <div style={{width:"500px"}}>
            <ListGroup>
                <ListGroupItem className="justify-content-between">Cras justo odio{' '}<Badge pill>14</Badge></ListGroupItem>
                <ListGroupItem className="justify-content-between">Dapibus ac facilisis in{' '}<Badge pill>2</Badge></ListGroupItem>
                <ListGroupItem className="justify-content-between">Morbi leo risus{' '}<Badge pill>1</Badge></ListGroupItem>
            </ListGroup>
            <br/><br/>
            <ListGroup>
                <ListGroupItem className="justify-content-between" tag="a" href="https://n.news.naver.com/mnews/article/001/0014288496?sid=101" color="success">SK이노베이션, 피지 탄소감축 위해 맹그로브숲 복원 나서</ListGroupItem>
                <ListGroupItem className="justify-content-between" tag="a" href="https://n.news.naver.com/mnews/article/003/0012169548?sid=101">기업체감경기 '악화'…제조업은 소폭 '개선'</ListGroupItem>
                <ListGroupItem className="justify-content-between" tag="a" href="https://n.news.naver.com/mnews/article/421/0007132748?sid=101">한화오션 출범 후 첫 분기 ‘흑자전환’…영업이익 741억원</ListGroupItem>
            </ListGroup>
            <br/><br/>
            <ListGroup>
                <ListGroupItem>
                    <ListGroupItemHeading>중부지방 천둥·번개 동반 비…낮 최고 17∼25도[날씨]</ListGroupItemHeading>    
                    <ListGroupItemText>오후부터 밤 사이 중부지방과 전라권을 중심으로 돌풍과 천둥·번개를 동반한 비가 오는 곳이 있겠고, 우박이 떨어지는 곳도 있을 전망</ListGroupItemText>
                </ListGroupItem>        
                <ListGroupItem>
                    <ListGroupItemHeading>'개인정보 유출' 해외 결제 서비스 '페이팔' 과징금 9억원</ListGroupItemHeading>    
                    <ListGroupItemText>국외에 존재하는 글로벌 사업자를 대상으로 우리 보호법상 안전 조치의무를 적용해 위반 행위를 처분</ListGroupItemText>
                </ListGroupItem> 
                <ListGroupItem>
                    <ListGroupItemHeading>美의회 마비시킨 하원의장 공백 사태 최후 승자는 '트럼프 세력'</ListGroupItemHeading>    
                    <ListGroupItemText>프리덤 코커스 공동설립자로 초강경파의 일원인 짐 조던(오하이오) 법사위원장이 2번째 후보로 나섰다가 당내 중도파 등 20여명의 반대를 극복하지 못하고 물러서자 초강경파들은 '대안' 격으로 강경 보수 성향의 '이론가'이자 트럼프 전 대통령의 '열혈 지지자'인 존슨 의원을 밀었다.</ListGroupItemText>
                </ListGroupItem>         
            </ListGroup>
        </div>
    )
}

export default ListGroupStrap;