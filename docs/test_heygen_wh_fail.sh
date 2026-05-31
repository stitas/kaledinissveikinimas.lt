payload='{"event_type":"avatar_video.fail","event_data":{"video_id":"videoId","error":{"code":"mock_failure","message":"Mock HeyGen video generation failed"}}}'

signature=$(printf '%s' "$payload" | openssl dgst -sha256 -hmac "secret" -hex | sed 's/^.* //')

curl -i -X POST "http://localhost:8080/api/v1/video/hook" \
  -H "Content-Type: application/json" \
  -H "Heygen-Signature: $signature" \
  --data "$payload"