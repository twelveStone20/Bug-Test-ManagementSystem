export function parseJwt(token) {
  try {
    // 分割JWT
    const parts = token.split('.')
    if (parts.length !== 3) {
      throw new Error('Invalid JWT format')
    }

    // 解码头部
    const header = atob(parts[0])
    // 解码负载
    const payload = atob(parts[1])

    // 将解码后的字符串转换为JSON对象
    const headerObj = JSON.parse(header)
    const payloadObj = JSON.parse(payload)

    return {
      header: headerObj,
      payload: payloadObj,
      signature: parts[2]
    }
  } catch (e) {
    console.error('Failed to parse JWT:', e)
    return null
  }
}
