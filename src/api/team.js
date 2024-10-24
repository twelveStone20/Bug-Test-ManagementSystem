import request from '@/utils/testc'

export const addTeamService = ({
  teamId,
  teamName,
  teamMemberNumber,
  teamManagerId,
  teamManagerName
}) => {
  return request.post('http://localhost:8080/addteam', {
    teamId,
    teamName,
    teamMemberNumber,
    teamManagerId,
    teamManagerName
  })
}

export const getTeamInfoService = (creatorId) => {
  return request.get('http://localhost:8080/getteaminfo/' + creatorId)
}
