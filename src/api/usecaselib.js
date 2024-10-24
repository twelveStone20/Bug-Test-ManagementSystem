import request from '@/utils/testc'

export const addUsecaseLibService = ({
  usecaseLibraryName,
  libRelateTeamId,
  libCreatorId,
  libCreatorName
}) => {
  return request.post('http://localhost:8080/addusecaselib', {
    usecaseLibraryName,
    libRelateTeamId,
    libCreatorId,
    libCreatorName
  })
}

export const getAllUsecaseLibService = (teamId) => {
  return request.get('http://localhost:8080/allusecaselib/' + teamId)
}

export const getOneUsecaseLibService = (usecaseLibId) => {
  return request.get('http://localhost:8080/oneusecaselib/' + usecaseLibId)
}
